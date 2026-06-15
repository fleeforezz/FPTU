import React, { useState } from 'react';
import type { FormEvent } from 'react';
import type { MeetingTier, AllocationResult } from '../domain/meeting-types';
import { calculateAllocation } from '../use-cases/calculate-allocation';

export const AllocationCalculator: React.FC = () => {
    const [participants, setParticipants] = useState<string>('');
    const [tier, setTier] = useState<MeetingTier>('STANDARD');
    const [result, setResult] = useState<AllocationResult | null>(null);
    const [error, setError] = useState<string | null>(null);

    const handleSubmit = (e: FormEvent<HTMLFormElement>): void => {
        e.preventDefault();
        setError(null);
        setResult(null);

        try {
            const parsedCount = Number(participants);
            const allocation = calculateAllocation(parsedCount, tier);
            setResult(allocation);
        } catch (err: unknown) {
            if (err instanceof Error) {
                setError(err.message);
            } else {
                setError('An unexpected error occurred.');
            }
        }
    };

    return (
        <div className="calculator-container">
            <h2>Meeting Bandwidth Allocator</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="participants">Participant Count:</label>
                    <input
                        id="participants"
                        type="number"
                        value={participants}
                        onChange={(e) => setParticipants(e.target.value)}
                        required
                    />
                </div>

                <div>
                    <label htmlFor="tier">Meeting Tier:</label>
                    <select
                        id="tier"
                        value={tier}
                        onChange={(e) => setTier(e.target.value as MeetingTier)}
                    >
                        <option value="STANDARD">Standard</option>
                        <option value="GOVERNMENT">Government</option>
                    </select>
                </div>

                <button type="submit">Calculate Allocation</button>
            </form>

            {error && <div className="error-box">{error}</div>}

            {result && (
                <div className="result-box">
                    <p><strong>Resolution:</strong> {result.resolution}</p>
                    <p><strong>Total Bandwidth:</strong> {result.bandwidthMbps} Mbps</p>
                </div>
            )}
        </div>
    );
};
import { describe, it, expect } from 'vitest';
import { calculateAllocation } from './calculate-allocation';
import type { MeetingTier } from '../domain/meeting-types';

describe('calculateAllocation', () => {
    describe('Invalid Participants Input', () => {
        const invalidInputs = [0, -1, 1.5];
        
        invalidInputs.forEach(pts => {
            it(`should throw an error if participants is ${pts}`, () => {
                expect(() => calculateAllocation(pts, 'STANDARD')).toThrowError('Participants must be a positive integer.');
                expect(() => calculateAllocation(pts, 'GOVERNMENT')).toThrowError('Participants must be a positive integer.');
            });
        });
    });

    describe('STANDARD tier', () => {
        const tier: MeetingTier = 'STANDARD';

        it('should throw an error if participants > 100', () => {
            expect(() => calculateAllocation(101, tier)).toThrowError('Standard tier supports a maximum of 100 users.');
        });

        it('should allocate 720p and 2 Mbps per user for 1 to 10 participants', () => {
            expect(calculateAllocation(1, tier)).toEqual({ resolution: '720p', bandwidthMbps: 2 });
            expect(calculateAllocation(10, tier)).toEqual({ resolution: '720p', bandwidthMbps: 20 });
        });

        it('should allocate 480p and 1 Mbps per user for 11 to 50 participants', () => {
            expect(calculateAllocation(11, tier)).toEqual({ resolution: '480p', bandwidthMbps: 11 });
            expect(calculateAllocation(50, tier)).toEqual({ resolution: '480p', bandwidthMbps: 50 });
        });

        it('should allocate AUDIO_ONLY and 0.1 Mbps per user for 51 to 100 participants', () => {
            expect(calculateAllocation(51, tier)).toEqual({ resolution: 'AUDIO_ONLY', bandwidthMbps: 5.1 });
            expect(calculateAllocation(100, tier)).toEqual({ resolution: 'AUDIO_ONLY', bandwidthMbps: 10 });
        });
    });

    describe('GOVERNMENT tier', () => {
        const tier: MeetingTier = 'GOVERNMENT';

        it('should throw an error if participants > 100', () => {
            expect(() => calculateAllocation(101, tier)).toThrowError('Government nodes support a maximum of 100 users.');
        });

        it('should allocate 1080p and 4 Mbps per user for 1 to 20 participants', () => {
            expect(calculateAllocation(1, tier)).toEqual({ resolution: '1080p', bandwidthMbps: 4 });
            expect(calculateAllocation(20, tier)).toEqual({ resolution: '1080p', bandwidthMbps: 80 });
        });

        it('should allocate 720p and 2 Mbps per user for 21 to 100 participants', () => {
            expect(calculateAllocation(21, tier)).toEqual({ resolution: '720p', bandwidthMbps: 42 });
            expect(calculateAllocation(100, tier)).toEqual({ resolution: '720p', bandwidthMbps: 200 });
        });
    });
});

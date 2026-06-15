import type {
    MeetingTier,
    AllocationResult
} from '../domain/meeting-types';

export const calculateAllocation = (
    participants: number,
    tier: MeetingTier
): AllocationResult => {
    if (!Number.isInteger(participants) || participants < 1) {
        throw new Error('Participants must be a positive integer.');
    }

    // Government
    if (tier === 'GOVERNMENT') {
        if (participants > 100) {
            throw new Error('Government nodes support a maximum of 100 users.');
        }
        if (participants <= 20) {
            // 4 Mbps per user for 1080p 
            return { resolution: '1080p', bandwidthMbps: participants * 4 };
        }
        // 2 Mbps per user for 720p 
        return { resolution: '720p', bandwidthMbps: participants * 2 };
    }

    // STANDARD tier logic 
    if (participants > 100) {
        throw new Error('Standard tier supports a maximum of 100 users.');
    }
    if (participants <= 10) {
        // 2 Mbps per user for 720p 
        return { resolution: '720p', bandwidthMbps: participants * 2 };
    }
    if (participants <= 50) {
        // 1 Mbps per user for 480p 
        return { resolution: '480p', bandwidthMbps: participants * 1 };
    }
    // 0.1 Mbps per user for Audio Only 
    return { resolution: 'AUDIO_ONLY', bandwidthMbps: participants * 0.1 };
};
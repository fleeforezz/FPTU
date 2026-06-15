export type MeetingTier = 'STANDARD' | 'GOVERNMENT';
export type Resolution = '1080p' | '720p' | '480p' | 'AUDIO_ONLY';

export interface AllocationResult {
    resolution: Resolution;
    bandwidthMbps: number;
}
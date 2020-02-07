package com.github.dockerjava.api.model;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.CheckForNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Representation of a Docker statistics.
 */
@EqualsAndHashCode
@ToString
public class Statistics implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("read")
    private String read;

    /**
     * @since Docker Remote API 1.21
     */
    @CheckForNull
    @JsonProperty("networks")
    private Map<String, StatisticNetworksConfig> networks;

    /**
     * @deprecated as of Docker Remote API 1.21, replaced by {@link #networks}
     */
    @Deprecated
    @JsonProperty("network")
    private StatisticNetworksConfig network;

    @JsonProperty("memory_stats")
    private MemoryStatsConfig memoryStats;

    @JsonProperty("blkio_stats")
    private BlkioStatsConfig blkioStats;

    @JsonProperty("cpu_stats")
    private CpuStatsConfig cpuStats;

    /**
     * @since Docker Remote API 1.19
     */
    @JsonProperty("precpu_stats")
    private CpuStatsConfig preCpuStats;

    /**
     * @since Docker Remote API 1.23
     */
    @JsonProperty("pids_stats")
    private PidsStatsConfig pidsStats;

    public String getRead() {
        return read;
    }

    /**
     * @since Docker Remote API 1.21
     */
    @CheckForNull
    public Map<String, StatisticNetworksConfig> getNetworks() {
        return networks;
    }

    /**
     * @deprecated as of Docker Remote API 1.21, replaced by {@link #getNetworks()}
     */
    @Deprecated
    public StatisticNetworksConfig getNetwork() {
        return network;
    }

    public CpuStatsConfig getCpuStats() {
        return cpuStats;
    }

    /**
     * The cpu statistic of last read, which is used for calculating the cpu usage percent.
     * It is not the exact copy of the {@link #getCpuStats()}.
     */
    public CpuStatsConfig getPreCpuStats() {
        return preCpuStats;
    }

    public MemoryStatsConfig getMemoryStats() {
        return memoryStats;
    }

    public BlkioStatsConfig getBlkioStats() {
        return blkioStats;
    }

    public PidsStatsConfig getPidsStats() {
        return pidsStats;
    }
}

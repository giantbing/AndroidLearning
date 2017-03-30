package com.example.giant.rxandroidlearning.unitl;

/**
 * Created by giant on 2017/3/30.
 */

public class ApiBuildTest {


    private String HostName;
    private String Port;


    private void initclass(final Builder builder) {

        this.HostName = builder.HostName;
        this.Port = builder.Port;

    }

    private ApiBuildTest(Builder builder) {
        if (builder != null)
            initclass(builder);

    }

    public static Builder Builder() {

        return new Builder();

    }

    public final static class Builder {
        private String HostName;
        private String Port;

        public Builder() {
        }

        public Builder setHostName(String hostName) {
            this.HostName = hostName;
            return this;
        }

        public Builder setPort(String port) {
            this.Port = port;
            return this;
        }

        public ApiBuildTest build() {

            return new ApiBuildTest(this);
        }
    }
}

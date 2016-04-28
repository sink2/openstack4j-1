package org.openstack4j.openstack.gbp.domain;

import java.util.List;
import java.util.Map;

import org.openstack4j.model.gbp.L3Policy;
import org.openstack4j.model.gbp.builder.L3PolicyBuilder;
import org.openstack4j.openstack.common.ListResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
/**
 * Model implementation for L3 Policy
 * 
 * @author vinod borole
 */
@JsonRootName("l3_policy")
public class GbpL3Policy implements L3Policy {
    private static final long serialVersionUID = 1L;
    private String name;
    @JsonProperty("tenant_id")
    private String tenantId;
    private String id;
    private String description;
    @JsonProperty("external_segments")
    private Map<String, List<String>> externalSegments;
    @JsonProperty("ip_pool")
    private String ipPool;
    @JsonProperty("ip_version")
    private String ipVersion;
    @JsonProperty("l2_policies")
    private List<String> l2Policies;
    private List<String> routers;
    private boolean shared;
    @JsonProperty("subnet_prefix_length")
    private String subnetPrefixLength;
    
    

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(String tenantId) {
        this.tenantId=tenantId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Map<String, List<String>> getExternalSegments() {
        return externalSegments;
    }

    @Override
    public String getIpPool() {
        return ipPool;
    }

    @Override
    public String getIpVersion() {
        return ipVersion;
    }

    @Override
    public List<String> getL2Policies() {
        return l2Policies;
    }

    @Override
    public List<String> getRouters() {
        return routers;
    }

    @Override
    public boolean isShared() {
        return shared;
    }

    @Override
    public String getSubnetPrefixLength() {
        return subnetPrefixLength;
    }

    @Override
    public L3PolicyBuilder toBuilder() {
        return new L3PolicyConcreteBuilder(this);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues().add("id", id).add("name", name).add("desription", description)
                .add("tenantId", tenantId).add("externalSegments", externalSegments).add("ipPool", ipPool).add("ipVersion", ipVersion)
                .add("l2Policies", l2Policies).add("routers", routers).add("shared", shared).add("subnetPrefixLength", subnetPrefixLength).toString();
    }

    public static class L3Policies extends ListResult<GbpL3Policy>{

        private static final long serialVersionUID = 1L;
        @JsonProperty("l3_policies")
        private List<GbpL3Policy> l3Policies;
        
        @Override
        protected List<GbpL3Policy> value() {
            return l3Policies;
        }
        
    }
    
    public static class L3PolicyConcreteBuilder implements L3PolicyBuilder{

        private GbpL3Policy l3Policy;
        
        public L3PolicyConcreteBuilder(GbpL3Policy gbpL3Policy) {
            this.l3Policy=gbpL3Policy;
        }

        @Override
        public L3Policy build() { 
            return l3Policy;
        }

        @Override
        public L3PolicyBuilder from(L3Policy in) {
            this.l3Policy = (GbpL3Policy) in;
            return this;
        }
        
    }
}

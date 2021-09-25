package com.dfsek.terra.addons.feature.distributor.config;

import com.dfsek.tectonic.loading.object.ObjectTemplate;

import com.dfsek.terra.api.structure.feature.Distributor;


public class YesDistributorTemplate implements ObjectTemplate<Distributor> {
    @Override
    public Distributor get() {
        return Distributor.yes();
    }
}

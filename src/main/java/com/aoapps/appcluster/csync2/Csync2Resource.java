/*
 * ao-appcluster-csync2 - Application-level clustering tools for Csync2.
 * Copyright (C) 2011, 2016, 2020, 2021, 2022  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-appcluster-csync2.
 *
 * ao-appcluster-csync2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-appcluster-csync2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-appcluster-csync2.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aoapps.appcluster.csync2;

import com.aoapps.appcluster.AppCluster;
import com.aoapps.appcluster.AppClusterConfigurationException;
import com.aoapps.appcluster.CronResource;
import com.aoapps.appcluster.ResourceConfiguration;
import com.aoapps.appcluster.ResourceNode;
import com.aoapps.collections.AoCollections;
import java.util.Collection;
import java.util.Set;

/**
 * Synchronizes resources using csync2.
 *
 * @author  AO Industries, Inc.
 */
public class Csync2Resource extends CronResource<Csync2Resource, Csync2ResourceNode> {

  private final boolean allowMultiMaster;
  private final Set<String> groups;

  protected Csync2Resource(AppCluster cluster, Csync2ResourceConfiguration resourceConfiguration, Collection<? extends ResourceNode<?, ?>> resourceNodes) throws AppClusterConfigurationException {
    super(cluster, resourceConfiguration, resourceNodes);
    this.allowMultiMaster = resourceConfiguration.getAllowMultiMaster();
    this.groups = AoCollections.unmodifiableCopySet(resourceConfiguration.getGroups());
  }

  @Override
  public boolean getAllowMultiMaster() {
    return allowMultiMaster;
  }

  @SuppressWarnings("ReturnOfCollectionOrArrayField") // Returning unmodifiable
  public Set<String> getGroups() {
    return groups;
  }

  @Override
  protected Csync2ResourceSynchronizer newResourceSynchronizer(Csync2ResourceNode localResourceNode, Csync2ResourceNode remoteResourceNode, ResourceConfiguration<Csync2Resource, Csync2ResourceNode> resourceConfiguration) throws AppClusterConfigurationException {
    Csync2ResourceConfiguration csync2ResourceConfiguration = (Csync2ResourceConfiguration)resourceConfiguration;
    return new Csync2ResourceSynchronizer(
      localResourceNode,
      remoteResourceNode,
      csync2ResourceConfiguration.getSynchronizeSchedule(localResourceNode, remoteResourceNode),
      csync2ResourceConfiguration.getTestSchedule(localResourceNode, remoteResourceNode)
    );
  }
}

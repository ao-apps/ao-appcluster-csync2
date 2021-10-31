/*
 * ao-appcluster-csync2 - Application-level clustering tools for Csync2.
 * Copyright (C) 2011, 2016, 2021  AO Industries, Inc.
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
import com.aoapps.appcluster.CronResourceConfiguration;
import com.aoapps.appcluster.ResourceNode;
import java.util.Collection;
import java.util.Set;

/**
 * The configuration for a csync2 resource.
 *
 * @author  AO Industries, Inc.
 */
public interface Csync2ResourceConfiguration extends CronResourceConfiguration<Csync2Resource, Csync2ResourceNode> {

	/**
	 * @see Csync2Resource#getAllowMultiMaster()
	 */
	boolean getAllowMultiMaster();

	/**
	 * Gets all the groups that will be synchronized by csync2 for this resource.
	 */
	Collection<String> getGroups();

	@Override
	Set<? extends Csync2ResourceNodeConfiguration> getResourceNodeConfigurations() throws AppClusterConfigurationException;

	@Override
	Csync2Resource newResource(AppCluster cluster, Collection<? extends ResourceNode<?, ?>> resourceNodes) throws AppClusterConfigurationException;
}

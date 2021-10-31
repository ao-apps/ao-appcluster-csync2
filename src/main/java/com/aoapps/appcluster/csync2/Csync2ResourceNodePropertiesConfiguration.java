/*
 * ao-appcluster-csync2 - Application-level clustering tools for Csync2.
 * Copyright (C) 2011, 2016, 2019, 2021  AO Industries, Inc.
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

import com.aoapps.appcluster.AppClusterConfigurationException;
import com.aoapps.appcluster.AppClusterPropertiesConfiguration;
import com.aoapps.appcluster.CronResourceNodePropertiesConfiguration;
import com.aoapps.appcluster.Node;

/**
 * The configuration for a csync2 resource.
 *
 * @author  AO Industries, Inc.
 */
public class Csync2ResourceNodePropertiesConfiguration extends CronResourceNodePropertiesConfiguration<Csync2Resource, Csync2ResourceNode> implements Csync2ResourceNodeConfiguration {

	private final String exe;

	protected Csync2ResourceNodePropertiesConfiguration(AppClusterPropertiesConfiguration properties, String resourceId, String nodeId, String type) throws AppClusterConfigurationException {
		super(properties, resourceId, nodeId);
		this.exe = properties.getString("appcluster.resource."+resourceId+".node."+nodeId+"."+type+".exe", true);
	}

	@Override
	public String getExe() {
		return exe;
	}

	@Override
	public Csync2ResourceNode newResourceNode(Node node) throws AppClusterConfigurationException {
		return new Csync2ResourceNode(node, this);
	}
}

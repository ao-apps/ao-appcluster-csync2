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
 * along with ao-appcluster-csync2.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.appcluster.csync2;

import com.aoindustries.appcluster.AppClusterConfigurationException;
import com.aoindustries.appcluster.CronResourceNode;
import com.aoindustries.appcluster.Node;

/**
 * The node settings for csync2 synchronization.
 *
 * @author  AO Industries, Inc.
 */
public class Csync2ResourceNode extends CronResourceNode<Csync2Resource, Csync2ResourceNode> {

	private final String exe;

	protected Csync2ResourceNode(Node node, Csync2ResourceNodeConfiguration resourceNodeConfiguration) throws AppClusterConfigurationException {
		super(node, resourceNodeConfiguration);
		this.exe = resourceNodeConfiguration.getExe();
	}

	/**
	 * Gets the path to the csync2 executable.
	 */
	public String getExe() {
		return exe;
	}
}

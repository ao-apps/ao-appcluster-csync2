/*
 * ao-appcluster-csync2 - Application-level clustering tools for Csync2.
 * Copyright (C) 2021  AO Industries, Inc.
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
module com.aoapps.appcluster.csync2 {
	exports com.aoapps.appcluster.csync2;
	// Direct
	requires com.aoapps.appcluster.core; // <groupId>com.aoapps</groupId><artifactId>ao-appcluster-core</artifactId>
	requires com.aoapps.collections; // <groupId>com.aoapps</groupId><artifactId>ao-collections</artifactId>
	requires com.aoapps.cron; // <groupId>com.aoapps</groupId><artifactId>ao-cron</artifactId>
	requires com.aoapps.lang; // <groupId>com.aoapps</groupId><artifactId>ao-lang</artifactId>
	requires org.dnsjava; // <groupId>dnsjava</groupId><artifactId>dnsjava</artifactId>
}

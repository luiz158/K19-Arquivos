/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat, Inc. and/or its affiliates or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */

package org.hibernate.search.query.dsl;

/**
 * Query builder that needs contextualization:
 * A query builder should know which entity or analyzer it relies on.
 *
 * <code>
 * QueryBuilder builder =
 * searchFactory.buildQueryBuilder()
 *   .forEntity(Customer.class)
 *     .overridesForField("profession", "acronym-analyzer")
 *     .get();
 * </code>
 *
 * overridesForField is optional (and usually not needed). This method overrides the
 * underlying analyzer (for a given field) used to build queries.
 *
 * @author Emmanuel Bernard
 */
public interface QueryContextBuilder {
	//TODO make a forEntities

	/**
	 * Creates an entity context which can be used to obtain a {@link QueryBuilder}.
	 * </p>
	 * Note that the passed entity type is used to verify field names, transparently apply analyzers and field bridges
	 * etc. The query result list, however, is not automatically restricted to the given type. Instead a type filter
	 * must be applied when creating the full text query in order to restrict the query result to certain entity types.
	 *
	 * @param entityType entity type used for meta data retrieval during query creation
	 * @return an entity context
	 */
	EntityContext forEntity(Class<?> entityType);
}

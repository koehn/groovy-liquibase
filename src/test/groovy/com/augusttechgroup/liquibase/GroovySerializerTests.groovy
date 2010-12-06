//
// Groovy Liquibase ChangeLog
//
// Copyright (C) 2010 Tim Berglund
// http://augusttechgroup.com
// Littleton, CO
//
// Licensed under the Apache License 2.0
//

package com.augusttechgroup.liquibase

import liquibase.serializer.ChangeLogSerializer
import liquibase.changelog.DatabaseChangeLog
import liquibase.changelog.ChangeSet
import liquibase.change.Change
import liquibase.sql.visitor.SqlVisitor
import liquibase.change.ColumnConfig
import liquibase.resource.FileSystemResourceAccessor
import liquibase.serializer.ChangeLogSerializerFactory


import org.junit.Test
import org.junit.Before
import static org.junit.Assert.*


/**
 * An implementation
 *
 * @author Tim Berglund
 */
class GroovySerializerTests
{
  def resourceAccessor
  def serializerFactory


  @Before
  void registerSerializer() {
    resourceAccessor = new FileSystemResourceAccessor(baseDirectory: '.')
    serializerFactory = ChangeLogSerializerFactory.instance
    ChangeLogSerializerFactory.getInstance().register(new GroovyChangeLogSerializer())
  }


  @Test
  void onlyGroovyFilesAreSupported() {
    def serializer = new GroovyChangeLogSerializer()
    assertArrayEquals(['groovy'] as String[], serializer.validFileExtensions)
  }


}
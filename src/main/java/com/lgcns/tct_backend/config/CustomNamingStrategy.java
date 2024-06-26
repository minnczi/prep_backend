package com.lgcns.tct_backend.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy implements PhysicalNamingStrategy {

  @Override
  public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnv) {
    return convert(identifier);
  }

  @Override
  public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnv) {
    return convert(identifier);
  }

  @Override
  public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnv) {
    return convert(identifier);
  }

  @Override
  public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnv) {
    return convert(identifier);
  }

  @Override
  public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnv) {
    return convert(identifier);
  }

  private Identifier convert(Identifier identifier) {
    if (identifier == null || identifier.getText().isEmpty()) {
      return identifier;
    }

    String regex = "([a-z])([A-Z])";
    String replacement = "$1_$2";
    String newName = identifier.getText().replaceAll(regex, replacement).toLowerCase();
    return Identifier.toIdentifier(newName);
  }
}

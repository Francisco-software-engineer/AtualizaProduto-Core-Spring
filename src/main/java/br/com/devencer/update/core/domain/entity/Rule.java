package br.com.devencer.update.core.domain.entity;

public interface Rule {
  int compareTo(Product product,Product anotherProduct);
  String toString(Product product);
  boolean equals(Product product,Product anotherProduct);
  int hashCode(Product product);
}

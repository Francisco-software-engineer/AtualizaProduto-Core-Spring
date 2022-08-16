package unit.filters;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
    // Mapper
    "br.com.devencer.update.core.domain.mapper",
    // Local mock
    "br.com.devencer.update.driven.local"})
public class Build1 {
  // Build 1: Adaptador Testes -> Core <- Mocks
}
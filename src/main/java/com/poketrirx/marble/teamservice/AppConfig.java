package com.poketrirx.marble.teamservice;

import com.poketrirx.marble.framework.config.MarbleFrameworkConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(MarbleFrameworkConfig.class)
@Configuration
public class AppConfig {}
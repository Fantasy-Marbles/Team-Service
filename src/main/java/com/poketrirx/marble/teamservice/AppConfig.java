package com.poketrirx.marble.teamservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.poketrirx.marble.framework.config.MarbleFrameworkConfig;

@Import(MarbleFrameworkConfig.class)
@Configuration
public class AppConfig {}
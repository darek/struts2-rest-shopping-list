package com.darekzon.shoppinglist.listener;

/**
 * Copyright (C) 2006 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.darekzon.shoppinglist.mongoose.EntityManager;
import com.darekzon.shoppinglist.mongoose.EntityManagerImpl;
import com.darekzon.shoppinglist.repository.ProductRepository;
import com.darekzon.shoppinglist.repository.ProductRepositoryImpl;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.struts2.Struts2GuicePluginModule;

/**
 * Example application module.
 *
 * @author crazybob@google.com (Bob Lee)
 * @author darek@darekzon.com (Darek Zon)
 */
public class GuiceStruts2PluginListener extends GuiceServletContextListener {

  public Injector getInjector() {
    return Guice.createInjector(
      new Struts2GuicePluginModule(),
      new ServletModule() {
        @Override
        protected void configureServlets() {      
          // Struts 2 setup
          bind(StrutsPrepareAndExecuteFilter.class).in(Singleton.class);
          filter("/*").through(StrutsPrepareAndExecuteFilter.class);
          
          //bind(ServletContextEvent.class).in(Singleton.class);
          bind(EntityManager.class).to(EntityManagerImpl.class).asEagerSingleton();
  	      bind(ProductRepository.class).to(ProductRepositoryImpl.class);
      }
    });
  }

}
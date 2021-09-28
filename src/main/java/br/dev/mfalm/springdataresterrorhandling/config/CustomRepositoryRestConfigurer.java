package br.dev.mfalm.springdataresterrorhandling.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class CustomRepositoryRestConfigurer implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    @Lazy
    private Validator validator;

    /**
     * Expõe os id's de todas as entidades
     *
     * @param config Spring Data REST configuration options.
     * @param cors Assists with the registration of global, URL pattern based CorsConfiguration mappings.
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));
    }

    /**
     * Ativa os validadores beforeCreate e beforeSave para todas as entidades
     *
     * @param validatingListener ApplicationListener implementation that dispatches RepositoryEvents to a specific Validator.
     */
    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", validator);
        validatingListener.addValidator("beforeSave", validator);
    }

}
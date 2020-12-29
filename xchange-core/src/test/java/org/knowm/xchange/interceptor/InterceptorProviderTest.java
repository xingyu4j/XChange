package org.knowm.xchange.interceptor;

import org.junit.Test;
import si.mazi.rescu.Interceptor;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class InterceptorProviderTest {

    @Test
    public void testResolveInterceptors() {
        final Collection<Interceptor> resolvedInterceptors = InterceptorProvider.provide();

        assertThat(resolvedInterceptors).hasSize(1);
        assertThat(resolvedInterceptors.iterator().next()).isInstanceOf(TestInterceptor.class);
    }
}

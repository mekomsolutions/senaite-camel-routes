/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.config;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.openMocks;

import org.apache.hc.client5.http.utils.Base64;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;

class SenaiteConfigTest {

    @InjectMocks
    private SenaiteConfig senaiteConfig;

    private static AutoCloseable mocksCloser;

    @BeforeEach
    void setUp() {
        mocksCloser = openMocks(this);
        ReflectionTestUtils.setField(senaiteConfig, "senaiteUsername", "testUser");
        ReflectionTestUtils.setField(senaiteConfig, "senaitePassword", "testPass");
        ReflectionTestUtils.setField(senaiteConfig, "senaiteBaseUrl", "http://localhost:8080");
    }

    @AfterAll
    static void close() throws Exception {
        mocksCloser.close();
    }

    @Test
    void shouldReturnEncodedAuthHeaderGivenValidUsernamePassword() {
        String expectedAuthHeader = "Basic " + new String(Base64.encodeBase64(("testUser:testPass").getBytes()));

        String authHeader = senaiteConfig.authHeader();

        assertEquals(expectedAuthHeader, authHeader);
    }

    @Test
    void shouldThrowsExceptionWhenUsernameIsEmpty() {
        ReflectionTestUtils.setField(senaiteConfig, "senaiteUsername", "");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            senaiteConfig.authHeader();
        });

        assertEquals("SENAITE username is empty", exception.getMessage());
    }

    @Test
    void shouldThrowsExceptionWhenPasswordIsEmpty() {
        ReflectionTestUtils.setField(senaiteConfig, "senaitePassword", "");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            senaiteConfig.authHeader();
        });

        assertEquals("SENAITE password is empty", exception.getMessage());
    }
}

package com.tierconnect.riot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import java.io.File;
import java.io.IOException;

/**
 * YamUtils class.
 *
 * @author jantezana
 * @version 8/19/16
 */
public final class YamUtils {

    /**
     * Reads a YML file.
     *
     * @param file the file
     * @param clazz the class
     * @param <T> the type
     * @return the type
     * @throws IOException
     */
    public static <T> Optional<T> readYmlFile(final File file, final Class<T> clazz)
    throws IOException {
        synchronized (YamUtils.class) {
            Preconditions.checkNotNull(file);
            final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            T object = mapper.readValue(file, clazz);
            return Optional.fromNullable(object);
        }
    }
}

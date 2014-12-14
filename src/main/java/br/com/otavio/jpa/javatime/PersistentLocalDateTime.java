/*
 * Copyright 2014 Otávio S Garcia
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.otavio.jpa.javatime;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convert a {@link java.time.LocalDateTime} into database column representation as {@link java.sql.Timestamp} and back again.
 * 
 * @author Otávio S Garcia
 */
@Converter(autoApply = true)
public class PersistentLocalDateTime implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public java.sql.Timestamp convertToDatabaseColumn(LocalDateTime value) {
		return value == null ? null : Timestamp.valueOf(value);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp value) {
		return value == null ? null : value.toLocalDateTime();
	}
}

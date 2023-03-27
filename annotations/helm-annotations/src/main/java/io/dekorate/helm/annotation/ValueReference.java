/**
 * Copyright 2018 The original authors.
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
 *
 **/
package io.dekorate.helm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.CONSTRUCTOR, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueReference {

  String property();

  /**
   * The path expressions where to map the property.
   */
  String[] paths();

  String profile() default "";

  String value() default "";

  /**
   * If not provided, it will use `{{ .Values.<root alias>.<property> }}`.
   * 
   * @return The complete Helm expression to be replaced with.
   */
  String expression() default "";

  String description() default "";

  int minimum() default Integer.MIN_VALUE;

  int maximum() default Integer.MAX_VALUE;

  String pattern() default "";

  boolean required() default false;
}

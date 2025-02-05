/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.strutsel.taglib.utils;

import jakarta.el.ExpressionFactory;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;

/**
 * This class is used in the <code>evaluateExpressions</code> method of each
 * Tag class.  It is used to process the original attribute value through the
 * JSTL EL engine to produce an evaluated value.  It provides functions to
 * evaluate the expression assuming it is an Object, String, Integer, or
 * Boolean result.
 */
public final class EvalHelper {
    private EvalHelper() {
    }

    /**
     * Evaluates the attribute value in the JSTL EL engine, returning the raw
     * Object value of the evaluated expression.  If the original expression
     * is null, or the resulting value is null, it will return null.
     */
    public static Object eval(String attrName, String attrValue, Tag tagObject, PageContext pageContext) {
        Object result = null;

        if (attrValue != null) {
            result = ExpressionFactory.newInstance().createValueExpression(pageContext.getELContext(), attrValue, Object.class).getValue(pageContext.getELContext());;
        }

        return result;
    }

    /**
     * Evaluates the attribute value in the JSTL EL engine, assuming the
     * resulting value is a String object.  If the original expression is
     * null, or the resulting value is null, it will return null.
     */
    public static String evalString(String attrName, String attrValue, Tag tagObject, PageContext pageContext)
            throws JspException {
        String result = null;

        if (attrValue != null) {
            result = ExpressionFactory.newInstance().createValueExpression(pageContext.getELContext(), attrValue, String.class).getValue(pageContext.getELContext());
        }

        return result;
    }

    /**
     * Evaluates the attribute value in the JSTL EL engine, assuming the
     * resulting value is an Integer object.  If the original expression is
     * null, or the resulting value is null, it will return null.
     */
    public static Integer evalInteger(String attrName, String attrValue, Tag tagObject, PageContext pageContext) {
        Integer result = null;

        if (attrValue != null) {
            result = ExpressionFactory.newInstance().createValueExpression(pageContext.getELContext(), attrValue, Integer.class).getValue(pageContext.getELContext());;
        }

        return result;
    }

    /**
     * Evaluates the attribute value in the JSTL EL engine, assuming the
     * resulting value is an Boolean object.  If the original expression is
     * null, or the resulting value is null, it will return null.
     */
    public static Boolean evalBoolean(String attrName, String attrValue, Tag tagObject, PageContext pageContext)
            throws JspException {
        Boolean result = null;

        if (attrValue != null) {
            result = ExpressionFactory.newInstance().createValueExpression(pageContext.getELContext(), attrValue, Boolean.class).getValue(pageContext.getELContext());;
        }

        return result;
    }
}

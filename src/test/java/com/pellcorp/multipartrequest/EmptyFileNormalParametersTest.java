/*
 MultipartRequest servlet library
 Copyright (C) 2001-2013 by Jason Pell

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 A copy of the Lesser General Public License (lesser.txt) is included in 
 this archive or goto the GNU website http://www.gnu.org/copyleft/lesser.html.
 */
package com.pellcorp.multipartrequest;

import java.io.IOException;

import com.pellcorp.multipartrequest.MultipartFile;

import org.junit.Before;
import org.junit.Test;

/**
 */
public class EmptyFileNormalParametersTest extends AbstractDumpTestCase {
    @Before
    public void setUp() throws IOException {
        setUp("Multipart_EmptyFileUpload_NormalParameters_Firefox-2.0.0.3.dump");
    }

    @Test
    public void testIsMultipart() throws Exception {
        assertTrue("Request is multipart.", multiRequest.isMultipartRequest());
    }

    @Test
    public void testNormalParameters() {
        assertEquals("", "Jason", request.getParameter("name"));

        String nameValues[] = request.getParameterValues("name");
        assertEquals("There are two name parameters", 2, nameValues.length);

        assertEquals("", "Jason", nameValues[0]);
        assertEquals("", "Clair", nameValues[1]);

        assertEquals("", "Pell", request.getParameter("surname"));

        String surnameValues[] = request.getParameterValues("surname");
        assertEquals("There are two surname parameters", 2, surnameValues.length);

        assertEquals("", "Pell", surnameValues[0]);
        assertEquals("", "Harris", surnameValues[1]);

        assertEquals("", "Are you going to upload a file.\r\n", request.getParameter("stuff"));
    }

    @Test
    public void testFileParameters() {
        MultipartFile file = multiRequest.getFileParameter("file1");
        assertNull("file1 MultipartFile should not exist!, where file object is empty", file);

        MultipartFile file2 = multiRequest.getFileParameter("file2");
        assertNull("file2 MultipartFile should not exist!, where file object is empty", file2);
    }
}

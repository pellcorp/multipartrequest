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

import org.junit.Before;
import org.junit.Test;

public class MultiPartMultifileUploadNormalParametersTest extends AbstractDumpTestCase {
    @Before
    public void setUp() throws Exception {
        setUp("MultiPart_MultifileUpload_NormalParameters_Firefox-2.0.0.4.dump");
    }

    @Test
    public void testIsMultipart() throws Exception {
        assertTrue("Request is multipart.", multiRequest.isMultipartRequest());
    }
}

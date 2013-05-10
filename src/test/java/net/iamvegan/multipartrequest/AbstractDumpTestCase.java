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
package net.iamvegan.multipartrequest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.iamvegan.multipartrequest.util.DumpFile;

import org.apache.commons.fileupload.MockHttpServletRequest;

import org.junit.Assert;

public abstract class AbstractDumpTestCase extends Assert {
    protected HttpServletRequest request;
    protected HttpServletMultipartRequest multiRequest;

    public void setUp(String dumpFileName) throws IOException {
        DumpFile dumpFile = new DumpFile(dumpFileName);

        request = new MockHttpServletRequest(dumpFile.getContent(), dumpFile.getContentType());

        request = new HttpServletMultipartRequest(request);
        multiRequest = (HttpServletMultipartRequest)request;
    }
}

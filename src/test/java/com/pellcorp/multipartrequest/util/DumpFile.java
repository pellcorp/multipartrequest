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
package com.pellcorp.multipartrequest.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import com.pellcorp.multipartrequest.HttpServletMultipartRequest;
import com.pellcorp.multipartrequest.commons.fileupload.util.Streams;

public class DumpFile {
    private byte[] contents;
    private String contentType;

    public DumpFile(String fileName) throws IOException {
        InputStream in = DumpFile.class.getResourceAsStream("/dumps/" + fileName);
        if (in != null) {
            contents = Streams.asBytes(in);

            // i know this is not efficient, but do you see me caring!
            BufferedReader reader = new BufferedReader(new StringReader(new String(contents)));
            String boundary = reader.readLine();

            // where boundary is not found, its probably a normal upload.
            if (boundary == null || !boundary.startsWith("--")) {
                contentType = HttpServletMultipartRequest.URLENCODED_FORM_CONTENT_TYPE;
            } else {
                contentType = HttpServletMultipartRequest.MULTIPART_FORM_DATA + "; boundary=" + boundary;
            }
        } else {
            throw new IllegalArgumentException("Dump file " + fileName + " not found");
        }
    }

    public byte[] getContent() {
        return contents;
    }

    public String getContentType() {
        return contentType;
    }
}

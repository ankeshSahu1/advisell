/*
 * Copyright (C) 2017 Metazone Infotech Pvt Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mz.advisell.bo.uploadDocument;

import java.util.ArrayList;
import org.mz.advisell.model.Document;

/**
 *
 * @author parii
 */
public interface ClientProfileUploadDocumentBo {
    void uploadDocument(ArrayList<Document> documentList,String aadharNo);
    public void deleteDocuments(String aadharNo);
    public void deleteDocument(ArrayList<Document> deleteDocumentList, String aadharNo);
}

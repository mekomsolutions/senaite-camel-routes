/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.mapper.senaite;

import com.ozonehis.eip.openmrs.senaite.model.client.ClientDTO;
import com.ozonehis.eip.openmrs.senaite.model.contact.request.Contact;
import lombok.Setter;
import org.hl7.fhir.r4.model.ServiceRequest;
import org.springframework.stereotype.Component;

@Setter
@Component
public class ContactMapper {

    public Contact toSenaite(ServiceRequest serviceRequest, ClientDTO clientDTO) {
        if (serviceRequest == null) {
            return null;
        }
        Contact contact = new Contact();
        contact.setPortalType("Contact");
        if (!clientDTO.getUid().isEmpty()) {
            contact.setParentPath(clientDTO.getPath());
        }

        String[] nameSplit = serviceRequest.getRequester().getDisplay().split(" ");
        contact.setFirstName(nameSplit[0]);
        contact.setSurname(nameSplit[1]);

        return contact;
    }
}

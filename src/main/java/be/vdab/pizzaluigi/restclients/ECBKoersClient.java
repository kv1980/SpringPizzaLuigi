package be.vdab.pizzaluigi.restclients;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import be.vdab.pizzaluigi.exceptions.KoersClientException;


@Component
//@Primary
@Qualifier("ECB")
public class ECBKoersClient implements KoersClient{
	private final static Logger LOGGER = LoggerFactory.getLogger(ECBKoersClient.class);
	private final URL url;
	
	ECBKoersClient(@Value("${ECBKoersURL}") URL url) { 
		this.url = url; 
		}

	@Override
	public BigDecimal getDollarKoers() {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		try (InputStream stream = url.openStream()){
			XMLStreamReader reader  = factory.createXMLStreamReader(stream);
			try {
				while (reader.hasNext()) {
					if (reader.next() == XMLStreamConstants.START_ELEMENT && "USD".equals(reader.getAttributeValue(null, "currency"))) {
						LOGGER.info("koers gelezen via ECB");
						return new BigDecimal(reader.getAttributeValue(null,"rate"));
					}
				}
				String fout = "XML van ECB bevat geen attribute currency USD";
				LOGGER.error(fout);
				throw new KoersClientException(fout);
			} finally {
				reader.close();
			}
		} catch (IOException | NumberFormatException | XMLStreamException ex) {
			String fout = "De omzettingsfactor naar USD kon niet worden gelezen.";
			LOGGER.error(fout,ex);
			throw new KoersClientException(fout);		
		}
	}
}

package JoaoSupermarket.Util;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/*
 * Adapter class to convert between LocalDate and the ISO 8601
 * String representation of the date such as 'yyyy-MM-dd'
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}
	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}
}

package be.vdab.pizzaluigi.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import be.vdab.pizzaluigi.restclients.KoersClient;

@RunWith(MockitoJUnitRunner.class)
public class DefaultEuroServiceTest {
	@Mock private KoersClient dummyKoersClient;
	private DefaultEuroService euroService;

	@Before
	public void before() {
		when(dummyKoersClient.getDollarKoers()).thenReturn(BigDecimal.valueOf(1.5));
		euroService = new DefaultEuroService(dummyKoersClient);
	}

	@Test
	public void naarDollar() {
		assertEquals(0,BigDecimal.valueOf(3).compareTo(euroService.naarDollar(BigDecimal.valueOf(2))));
		verify(dummyKoersClient).getDollarKoers();
	}
}

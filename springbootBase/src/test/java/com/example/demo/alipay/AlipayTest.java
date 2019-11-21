package com.example.demo.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayEcoMycarParkingConfigSetRequest;
import com.alipay.api.response.AlipayEcoMycarParkingConfigSetResponse;

public class AlipayTest {
	public static void main(String[] args) throws AlipayApiException {
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
				"2019082266382364",
				"MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC7tIO8dcu99tt6AxL/xg0SVLS+Jj3EADOdKQR28GWJTIAKRdIRGt8MYy7e3RGk0rzuyd9VUUHDLmftAhFNPXMiY3kTcRK23IdMtuZ8KHPQAg6aZOscNJeG6lSqhMal1ok6dCkIch3stXNDUWuAYiBXFInaEdQ7P58c3Segw/CfMcpUkpbgoJ1265GJnxwFWB75zff7zLRJcZJbcwkHP12Qy5pGszyxL9ktfZT4pTdpVoUS/bX4/PnxTK2Ox1GEZQHSFD0wBqGqbtp0FUkWS8qBJ13/A8fyyUtLdcX+FmVeEaCitIa3GLhJE9mpMr3w5b6+RHQZNAFuCCo+mVfb4X4PAgMBAAECggEBALGhEyWOh99eM7aUIC+h+Y7GUEC9qafI1Q892LbBqiSzG1wdVLzRJBDx71IB/Idw0lBbA5kWi1gsmzajxUHGDCWX4uUuFRqtOPC1CQqnsWk/+RfMtt17O4X2TWcMvXwEuNpzQL14WK8/yzMCYuwccCRYEFgolSH4hBdphe3SXuwWL7dFToUNSCNn4HPLepFhDXepEGdGSvfd23oFlH/8NilfzQHf6EMhSIGlUQo1tbG4Y+IS6xQu5Gz3H9+LgO8jqx6/hjAWlPnrqr1BooJwQTgEUI0/E0XBqn7NgeqCY0h8B1317qjP8Xy5KqzYmsJmuBlBwKAdsmcwIoHKsLVs/ykCgYEA51xUPPgiYxY00khtkoDFV0nPpAjyQ3r4sGztA70Jx9xhTNK/53bZ/Vfr1QdoITuphIK/q8Uf8tXYFuPojJcp2CN56j0Aj1kcIrsQvqF1IyA58MaeGQvN0HkTlIOLeSI+OaOoBrBuzBntbxzUNys6bOM9yavk+hKnc5PZ2GFa0O0CgYEAz7H9Jlz++fgqa4t+XJeCTXg3haIYQt9Ali3wLBv0ajyoD4Vwsl/6dpSWLRDiE/jwZ/l33GmwiUKt6EqSa4qWXWFviS1pdJ5NpnG3nvE0eJwiSeJhVJVSrpP0iDP4DsRiKFuCc97taQzuq0eoQyvy/gMwmJh3oaY0J9JfsL9Gd2sCgYEAkZKSnloyqM4MJlPUPd4wTR/wOnI2nSb+22NuLm//e3W68y+X9/fcaX+sr7mdV2vG2c269EVwOMc81ApLBEsI1SpdR3lipM+Y2HGDs667mYJpcopGZ9P5iDbmjwfF9k4JgRLsYmkZDesybjthe+UDOggxlHdH9+FM43ggFfoLvnECgYEAuv6YWnruAicCIlO0UC8E3TT4YDOBvmt8nfn8O+prU18LPPY6cg7h1POQhkCmG69M24AK/4KUs/A53WOOko5zNN3t6sbdJGcGqG3IEa0/PbvtTzInyVyr1YxWZG7NzpXXflhtil9Sxvsiw0k/4EJog3Rhw3G6e+rFGHlbOCnuisMCgYAgkolu2pKWDHKYTJkkUC3u3DHoVCoTFFNQkuYV7xZFeCQU4Zl6OkZi1MpCNdnd1UtSDbldOFHJ9eo3wim81fSKq5KQKlFCrv+KQ9c/EmM7p2t6BMmWb+MESt3552yu6DAARq/He1ZBOvyVuQPbOkQCwpzW3YROBbR9u6jT93vKMg==",
				"json","GBK",
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk1uMXrAoMEEEkVlM7huQpWk2itjFHKJoPzPsKSMnOPcOTomOCrR+nCzOlLVQ4zuNjcNY6cA8W0lMLVPYkcLz6HzZUVJSFaX2Y5NimOcuAjeUCmBLv/Cgc2LoFBEpGij8+YxJbT/SljyrnhnIko0O0x/43/zOGKytQK0mtOG4zvA5uxbd3b60cTdKhV5iBjNhcTWF5wCG2v8gexgmQGC9RK2o56+9PNAaPydXvvbuMPJ1UN90n1FcePrnCmzd3Ak4fivieCl55jna+jG7X1E4epCQhmOWgcfxUtnvP9vQgQ8REgbHM12Aag+jBT/nBTAOGhgdId6pz8T5Q0YC09NaVQIDAQAB",
				"RSA2");
		AlipayEcoMycarParkingConfigSetRequest request = new AlipayEcoMycarParkingConfigSetRequest();
		request.setBizContent("{" +
		"\"merchant_name\":\"成都银行股份有限公司\"," +
		"\"merchant_service_phone\":\"15102841988\"," +
		"\"account_no\":\"epayx@bocd.com.cn\"," +
		"      \"interface_info_list\":[{" +
		"        \"interface_name\":\"alipay.eco.mycar.parking.userpage.query\"," +
		"\"interface_type\":\"interface_page\"," +
		"\"interface_url\":\"https%3A%2F%2Fwww.parking24.cn%2Frf_carlife_alipay%2FCarLifeAction%21alipayAuth.action\"" +
		"        }]," +
		"  }");
		AlipayEcoMycarParkingConfigSetResponse response = alipayClient.execute(request);
		if(response.isSuccess()){
		System.out.println("调用成功");
		System.out.println(response.getParams());
		} else {
		System.out.println("调用失败");
		}
	}
}

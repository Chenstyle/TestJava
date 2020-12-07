package com.test.jnatest;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class WLDecodeJNA {

//	public interface WLDecode extends Library {
//		WLDecode INSTANCE = (WLDecode) Native.loadLibrary("wldecode", WLDecode.class);
//		int WltToBmp(byte[] wltData,byte[] BmpData);
//	}

	public static void main(String[] args) {
		String photoImg = "574c66007e00320000ff851f5151513e75f06c12f30f654d7a6b9d30cc6ee9899ae3ee354006f48d95d36170b80dbf5b416ded67957ef421164fcf98b91320839fbbed5e6634f84cc7e2742685f0c686aa65078d45ae518201979a11aed45251515a3e802732882925bed19de688a6939b009ff06aa924c485b4dc780ddfe6f9928656c5bd54daf870225dd07593899d3f644c6c4e0f02619e2f61ef805957067359fa57b73e08ac479d47213686f1a0f6ad7ce3a46c436bae516e45b4be4f0ad85af4ef49735fa1d3d07b7a95ee865612082bbb42c91f585c21a460b3c6baea8ec3d92545d63bc796c6f73c4608a337158819a649305ac2cc689c69eea8d21c0cb88ac5bb34eb762bca1273667b9a7c09dc4f0f5de5fab931297acafae523dc13ef861690607bfb9b2519d2498081a0b7b27742146d51f8b029de7d2de8770a9fa98c6cca65c73fef6709eb895b10e14b284be6c8d3ca6c1b2a2ded7c03d2d8fd56720027d78bdb23c31b100b9f97e69af752a96fb2b31733241ed34ad7c31f840294ed08737a9b96ab7a30702d2bb57cb9a08dbe578e1603578b850d285567527578389acadd40d8a486bfec50a7c0d81ec383abf857257982f78338e41c6f696f1f82495d6662b20d12f020ae510ffadf14613990e57bad251070667fdbe385c44f273b74ef0e5aed9307161ec076cf617e25f6b6dea457dc7a0d5e9e0f5b63315048c0eba82fdee62968f08f518cf7427c55d4faea0c53dae40bc8dc917cfda2925fc679fb798235570ecbd90281ca3e014f7eca47925d8e717f1bf3223de894e331a1455508430654d63a373f1cd00d02699e882ca36222c79db6d6e338a8443b5d8afab8858edf615192dd08713735758ba4951ac8d0acfe536db114690dc1ecb189f8d2b1785bc2c9d73a074c25855a78c499633be853f8e6b998756d97353e64f7eeb57fd214c86fafd031d0d37f4dad0b9678fb9680b42e8135b35c0451f8b7326b52f7b4156558b09e81edd4f65715944e967c2736a2efa8f01ecf8b5fef09da7580435d34cbd0fcd2a8625dc4368688f9aa9c8766f87f7076402cc27ef3ddc37b6811b2f7026658566d62e2bf804698ad69076619fd9bfe92e5e937b0e197f68d79e958f08d28c54cdb2766315044311a2e03048e4ed1748830d05d76a18f24109c017374414c14d5ab6736a4521fa81ae4983c92c1834c608a4ed58767b7915a3ea7499f2839d91d0a0ea31e9977d9e342c5717b94b799508555333e2761c190a82413152424ae51c9ab12748d8d270be568190a1d48a845e4171192f160e05176d7f7dc496ba5c4b9c4682d05926c9c5a3ec1114985040b90584266b390f862b6165d968ba3c3e480ba5e49c58915987c0a4f95bf211a1b4698dac23a031c789f90fcb527d6088da098d30b02a1052b19332649e001b39cfa37";
		byte[] ImgData = new byte[38862+1024]; //38862为bmp数据长度，1024为wlt数据长度
		byte[] photoData = new byte[1024];
		photoData = hexStringToBytes(photoImg);
//		int num = WLDecodeJNA.WLDecode.INSTANCE.WltToBmp(photoData,ImgData);
//		//0：失败  1：成功
//		System.out.println(num);
		System.out.println("ImgData len:"+ImgData.length);
		byte[] BmpData = new byte[38862];
		System.arraycopy(ImgData, 0, BmpData, 0, 38862);  //需要截取38862长度为bmp照片数据
		System.out.println(Base64.encode(BmpData));//转成base64格式

	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}


	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
}

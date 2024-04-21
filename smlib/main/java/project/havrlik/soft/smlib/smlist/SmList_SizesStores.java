package main.java.project.havrlik.soft.smlib.smlist;

public class SmList_SizesStores {
	
	/*
	 * 2^31 = 2_147_483_648
	 * max int 2_147_483_647
	 * Indexes of SM array can be from 0 to 2_147_483_646. Max index is -1 against max int.
	 */
	final int MAXSIZE = 2_147_483_647;
	
	
	private final SmList_SizesStore LIST_predefinedArraySizes_0_DEFAULT_128 = new SmList_SizesStore(
			"0",
			SmList_Size.DEFAULT_128,
			MAXSIZE,
			new int[][] {
				{0, 128, 128},
				{1, 640, 512},
				{2, 2_688, 2_048},
				{3, 10_880, 8_192},//
				{4, 27_264, 16_384},
				{5, 60_032, 32_768},
				{6, 125_568, 65_536},
				{7, 256_640, 131_072},
				{8, 518_784, 262_144},
				{9, 1_043_072, 524_288},
				{10, 2_091_648, 1_048_576},
				{11, 4_188_800, 2_097_152},
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_1_TINY_16 = new SmList_SizesStore(
			"1",
			SmList_Size.TINY_16,
			MAXSIZE,
			new int[][] {
				{0, 16, 16},//
				{1, 48, 32},
				{2, 112, 64},
				{3, 240, 128},
				{4, 496, 256},
				{5, 1_008, 512},
				{6, 2_032, 1_024},
				{7, 4_080, 2_048},
				{8, 8_176, 4_096},
				{9, 16_368, 8_192},
				{10, 32_752, 16_384},
				{11, 65_520, 32_768},
				{12, 131_056, 65_536},
				{13, 262_128, 131_072},
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_2_SMALL_64 = new SmList_SizesStore(
			"2",
			SmList_Size.SMALL_64,
			MAXSIZE,
			new int[][] {
				{0, 64, 64},
				{1, 320, 256},
				{2, 832, 512},//
				{3, 1_856, 1_024},
				{4, 3_904, 2_048},
				{5, 8_000, 4_096},
				{6, 16_192, 8_192},
				{7, 32_576, 16_384},
				{8, 65_344, 32_768},
				{9, 130_880, 65_536},
				{10, 261_952, 131_072},
				{11, 524_096, 262_144},
				{12, 655_168, 131_072},
				{13, 917_312, 262_144},
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_3_SMALL_512 = new SmList_SizesStore(
			"3",
			SmList_Size.SMALL_512,
			MAXSIZE,
			new int[][] {
				{0, 512, 512},
				{1, 2_560, 2_048},
				{2, 18_944, 16_384},
				{3, 51_712, 32_768},//
				{4, 117_248, 65_536},
				{5, 248_320, 131_072},
				{6, 510_464, 262_144},
				{7, 1_034_752, 524_288},
				{8, 2_083_328, 1_048_576},
				{9, 4_180_480, 2_097_152},
				{10, 8_374_784, 4_194_304},
				{11, 16_763_392, 8_388_608},
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_4_MEDIUM_4K = new SmList_SizesStore(
			"4",
			SmList_Size.MEDIUM_4K,
			MAXSIZE,
			new int[][] {
				{0, 4_096, 4_096},
				{1, 20_480, 16_384},
				{2, 86_016, 65_536},
				{3, 217_088, 131_072},//
				{4, 479_232, 262_144},
				{5, 1_527_808, 1_048_576},
				{6, 3_624_960, 2_097_152},
				{7, 7_819_264, 4_194_304},
				{8, 1_6207_872, 8_388_608},
				{9, 32_985_088, 16_777_216},
				{10, 66_539_520, 33_554_432},
				{11, 133_648_384, 67_108_864},
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_5_MEDIUM_32K = new SmList_SizesStore(
			"5",
			SmList_Size.MEDIUM_32K,
			MAXSIZE,
			new int[][] {
				{0, 32_768, 32_768},
				{1, 163_840, 131_072},
				{2, 688_128, 524_288},
				{3, 1_736_704, 1_048_576},//
				{4, 3_833_856, 2_097_152},
				{5, 8_028_160, 4_194_304},
				{6, 16_416_768, 8_388_608},
				{7, 33_193_984, 16_777_216},
				{8, 66_748_416, 33_554_432},
				{9, 133_857_280, 67_108_864},
//				{10, -, 134_217_728},
//				{11, -, 268_435_456},
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_6_BIG_256K = new SmList_SizesStore(
			"6",
			SmList_Size.BIG_256K,
			MAXSIZE,
			new int[][] {
				{0, 262_144, 262_144},
				{1, 1_310_720, 1_048_576},
				{2, 5_505_024, 4_194_304},
				{3, 13_893_632, 8_388_608},//
				{4, 30_670_848, 16_777_216},
				{5, 64_225_280, 33_554_432},
				{6, 131_334_144, 67_108_864},
				{7, 265_551_872, 134_217_728},
//				{8, -, 268_435_456},
//				{9, -, 536_870_912},
//				{10, -, 1_073_741_824},
//				{11, -, 2_147_483_647},//
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_7_BIG_2M = new SmList_SizesStore(
			"7",
			SmList_Size.BIG_2M,
			MAXSIZE,
			new int[][] {
				{0, 2_097_152, 2_097_152},
				{1, 10_485_760, 8_388_608},
//				{-, -, 16_777_216},
				{2, 44_040_192, 33_554_432},
				{3, 111_149_056, 67_108_864},//
				{4, 245_366_784, 134_217_728},
				{5, 513_802_240, 268_435_456},
				{6, 782_237_696, 268_435_456},
				{7, 1_050_673_152, 268_435_456},
				{8, 1_319_108_608, 268_435_456},
				{9, 1_587_544_064, 268_435_456},
				{10, 1_855_979_520, 268_435_456},
				{11, 2_124_414_976, 268_435_456},
				{12, 2_147_483_647, 23_068_671},////
//				{7, -, 536_870_912},
//				{8, -, 1_073_741_824},
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_8_HUGE_16M = new SmList_SizesStore(
			"8",
			SmList_Size.HUGE_16M,
			MAXSIZE,
			new int[][] {
				{0, 16_777_216, 16_777_216},
				{1, 83_886_080, 67_108_864},
				{2, 218_103_808, 134_217_728},//
				{3, 486_539_264, 268_435_456},
				{4, 1_023_410_176, 536_870_912},
				{5, 1_560_281_088, 536_870_912},
				{6, 2_147_483_647, 587_202_559},////
			}
			);
	
	private final SmList_SizesStore LIST_predefinedArraySizes_X1_TEST_6 = new SmList_SizesStore(
			"x1",
			SmList_Size.TEST_6,
			200,
			new int[][] {
				{0, 6, 6},
				{1, 12, 6},
				{2, 19, 7},
			}
			);
	private final SmList_SizesStore LIST_predefinedArraySizes_X2_TEST_7 = new SmList_SizesStore(
			"x2",
			SmList_Size.TEST_7,
			20_010,
			new int[][] {
				{0, 7, 7},
				{1, 16, 9},
				{2, 27, 11},
				{3, 57, 30},
			}
			);
	
	
	public final SmList_SizesStore[] LIST_predefinedArraySizes = {
			LIST_predefinedArraySizes_0_DEFAULT_128,
			
			LIST_predefinedArraySizes_1_TINY_16,
			LIST_predefinedArraySizes_2_SMALL_64,
			LIST_predefinedArraySizes_3_SMALL_512,
			LIST_predefinedArraySizes_4_MEDIUM_4K,
			LIST_predefinedArraySizes_5_MEDIUM_32K,
			LIST_predefinedArraySizes_6_BIG_256K,
			LIST_predefinedArraySizes_7_BIG_2M,
			LIST_predefinedArraySizes_8_HUGE_16M,
			
			LIST_predefinedArraySizes_X1_TEST_6,
			LIST_predefinedArraySizes_X2_TEST_7,
	};
	public SmList_Size smListSize_default;
	
	
	public SmList_SizesStores() {
		smListSize_default = SmList_Size.DEFAULT_128;
	}

}

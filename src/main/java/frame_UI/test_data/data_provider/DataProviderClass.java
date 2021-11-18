package frame_UI.test_data.data_provider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "dataForSearch")
    public static Object[][] dataForSearch() {
        return new Object[][]{
                {"apple"},
                {"samsung"},
                {"huawei"}
        };
    }

    @DataProvider(name = "dataProviderForReviewForm")
    public static Object[][] dataProviderForReviewForm() {
        return new Object[][]{
                {"apple", 5, 5, 5, 5, 5},
                {"samsung", 10, 10, 10, 9, 8},
                {"huawei", 20, 20, 19, 19, 20}
        };
    }

}

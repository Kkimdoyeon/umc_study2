package umc.umc_study_2.service.FoodCategoryService;

import java.util.List;

public interface FoodCategoryCommandService {
    boolean doAllCategoriesExist(List<Long> categoryIds);
}

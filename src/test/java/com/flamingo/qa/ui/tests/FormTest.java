package com.flamingo.qa.ui.tests;

import com.flamingo.qa.ui.data.StudentProvider;
import com.flamingo.qa.ui.model.Student;
import com.flamingo.qa.ui.pages.FinalForm;
import com.flamingo.qa.ui.pages.FormPage;
import com.flamingo.qa.ui.tests.base.BaseUITest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("ui")
@DisplayName("Form test")
public class FormTest extends BaseUITest {

    @Test
    public void formTest() {
        FormPage formPage = new FormPage();
        FinalForm finalForm = new FinalForm();
        Student student = StudentProvider.getStudent();
        formPage.fillForm(student);
        formPage.submit();
        assertThat(finalForm.getStudent()).isEqualTo(student);
    }
}

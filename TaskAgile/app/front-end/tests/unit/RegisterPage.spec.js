import { mount, createLocalVue } from "@vue/test-utils";
import RegisterPage from "@/views/RegisterPage";
import VueRouter from "vue-router";
import Vuelidate from "vuelidate";
import registrationService from "@/services/registration";

// Adding Vue Router to the test so that
// we can access vm.$router
const localVue = createLocalVue();
localVue.use(VueRouter);
localVue.use(Vuelidate);
const router = new VueRouter();

// Mock dependency registratinService
jest.mock("@/services/registration");

describe("RegisterPage.vue", () => {
    let wrapper;
    let fieldUsername;
    let fieldEmailAddress;
    let fieldPassword;
    let buttonSubmit;
    let registerSpy;
    let submitForm;

    beforeEach(() => {
        submitForm = jest.spyOn(RegisterPage.methods, "submitForm");
        wrapper = mount(RegisterPage, {
            localVue,
            router
        });
        fieldUsername = wrapper.find("#username");
        fieldEmailAddress = wrapper.find("#emailAddress");
        fieldPassword = wrapper.find("#password");
        buttonSubmit = wrapper.find('form button[type="submit"]');
        // Create spy for registration service
        registerSpy = jest.spyOn(registrationService, "register");
    });

    afterEach(() => {
        registerSpy.mockReset();
        registerSpy.mockRestore();
    });

    afterAll(() => {
        jest.restoreAllMocks();
    });

    it("should render registration form", () => {
        expect(wrapper.find(".logo").attributes().src).toEqual(
            "/static/images/logo.png"
        );
        expect(wrapper.find(".tagline").text()).toEqual(
            "Open source task management tool"
        );
        expect(fieldUsername.element.value).toEqual("");
        expect(fieldEmailAddress.element.value).toEqual("");
        expect(fieldPassword.element.value).toEqual("");
        expect(buttonSubmit.text()).toEqual("Create account");
    });

    it("should contain data model with initial values", () => {
        expect(wrapper.vm.form.username).toEqual("");
        expect(wrapper.vm.form.emailAddress).toEqual("");
        expect(wrapper.vm.form.password).toEqual("");
    });

    it("should have form inputs bound with data model", async () => {
        const username = "sunny";
        const emailAddress = "sunny@taskagile.com";
        const password = "VueJsRocks!";

        // vm form 에 할당하고 바로 가져오는 것은 sync 가 맞지 않음.
        // wrapper.vm.form.username = username;
        // wrapper.vm.form.emailAddress = emailAddress;
        // wrapper.vm.form.password = password;
        await wrapper.setData({
            form: {
                username: username,
                emailAddress: emailAddress,
                password: password
            }
        });

        expect(fieldUsername.element.value).toEqual(username);
        expect(fieldEmailAddress.element.value).toEqual(emailAddress);
        expect(fieldPassword.element.value).toEqual(password);
    });

    it("should have form submit event handler `submitForm`", () => {
        // setMethods is deprecated and will be removed in the next major version.
        // 위와 같은 이유로 submitForm Method 객체를 spyOn 으로 설정하고 Test
        // const stub = jest.fn();
        // wrapper.setMethods({ submitForm: stub });
        buttonSubmit.trigger("submit");
        expect(submitForm).toBeCalled();
    });

    it("should register when it is a new user", async () => {
        expect.assertions(2);
        const stub = jest.fn();
        wrapper.vm.$router.push = stub;

        wrapper.vm.form.username = "sunny";
        wrapper.vm.form.emailAddress = "sunny@taskagile.com";
        wrapper.vm.form.password = "JestRocks!";

        wrapper.vm.submitForm();
        expect(registerSpy).toBeCalled();
        await wrapper.vm.$nextTick();
        expect(stub).toHaveBeenCalledWith({ name: "LoginPage" });
    });

    it("should fail it is not a new user", async () => {
        expect.assertions(3);
        // In the mock, only sunny@taskagile.com is new user
        wrapper.vm.form.username = "ted";
        wrapper.vm.form.emailAddress = "ted@taskagile.com";
        wrapper.vm.form.password = "JestRocks!";

        expect(wrapper.find("#errorForm").isVisible()).toBe(false);
        // 예제에는 nextTick 만 await 를 걸었으나,
        // submitForm에서 걸어서 값이 할당 된 후에 확인 하도록 처리
        await wrapper.vm.submitForm();
        expect(registerSpy).toBeCalled();
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#errorForm").isVisible()).toBe(true);
    });

    it("should fail when the email address is invalid", () => {
        wrapper.vm.form.username = "test";
        wrapper.vm.form.emailAddress = "bad-email-address";
        wrapper.vm.form.password = "JestRocks!";
        wrapper.vm.submitForm();
        expect(registerSpy).not.toHaveBeenCalled();
    });

    it("should fail when the username is invalid", () => {
        wrapper.vm.form.username = "a";
        wrapper.vm.form.emailAddress = "test@taskagile.com";
        wrapper.vm.form.password = "JestRocks!";
        wrapper.vm.submitForm();
        expect(registerSpy).not.toHaveBeenCalled();
    });

    it("should fail when the password is invalid", () => {
        wrapper.vm.form.username = "test";
        wrapper.vm.form.emailAddress = "test@taskagile.com";
        wrapper.vm.form.password = "bad!";
        wrapper.vm.submitForm();
        expect(registerSpy).not.toHaveBeenCalled();
    });
});

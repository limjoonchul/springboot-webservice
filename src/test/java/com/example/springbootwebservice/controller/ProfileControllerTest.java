package com.example.springbootwebservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

class ProfileControllerTest {

    @Test
    void real_profile이_조회된다() {
        //given
        String viewedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(viewedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        assertThat(profile).isEqualTo(viewedProfile);
    }

    @Test
    public void real_profile이_없으면_첫번째가_조회된다() {
        //given
        String viewedProfile = "oauth";
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.addActiveProfile("oauth");
        mockEnvironment.addActiveProfile("real-db");
        ProfileController profileController = new ProfileController(mockEnvironment);

        //when
        String profile = profileController.profile();

        //then
        assertThat(profile).isEqualTo(viewedProfile);
    }

    @Test
    public void active_profile이_없으면_default가_조회된다() {
        //given
        String viewedProfile = "default";
        MockEnvironment mockEnvironment = new MockEnvironment();
        ProfileController profileController = new ProfileController(mockEnvironment);

        //when
        String profile = profileController.profile();

        //then
        assertThat(profile).isEqualTo(viewedProfile);
    }
}
package com.mns.cda.filsrouge.integration;

import com.mns.cda.filsrouge.model.AccountType;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AccountTypeControllerIntegrationTest extends BaseIntegrationTest {

    // ------------------------------------------------------------
    // GET /account-type/list
    // ------------------------------------------------------------

    @Test
    public void getAccountTypeList_withoutLogin_shouldReturn403() throws Exception {
        mvc.perform(get("/account-type/list"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "jean.dupont", roles = "USER")
    public void getAccountTypeList_asUser_shouldReturn403() throws Exception {
        mvc.perform(get("/account-type/list"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "claire.martin", roles = "ADMIN")
    public void getAccountTypeList_asAdmin_shouldReturn403() throws Exception {
        mvc.perform(get("/account-type/list"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "luc.bernard", roles = "SUPER_ADMIN")
    public void getAccountTypeList_asSuperAdmin_shouldReturn200() throws Exception {
        mvc.perform(get("/account-type/list"))
                .andExpect(status().isOk());
    }


    // ------------------------------------------------------------
    // GET /account-type/{id}
    // ------------------------------------------------------------

    @Test
    @WithMockUser(username = "luc.bernard", roles = "SUPER_ADMIN")
    public void getAccountTypeById_asSuperAdmin_shouldReturn200() throws Exception {
        mvc.perform(get("/account-type/3"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "luc.bernard", roles = "SUPER_ADMIN")
    public void getAccountTypeById_notExist_shouldReturn404() throws Exception {
        mvc.perform(get("/account-type/999"))
                .andExpect(status().isNotFound());
    }


    // ------------------------------------------------------------
    // POST /account-type
    // ------------------------------------------------------------

    @Test
    @WithMockUser(username = "jean.dupont", roles = "USER")
    public void createAccountType_asUser_shouldReturn403() throws Exception {
        AccountType type = new AccountType(null, "TEST");
        mvc.perform(post("/account-type")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(type)))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "claire.martin", roles = "ADMIN")
    public void createAccountType_asAdmin_shouldReturn403() throws Exception {
        AccountType type = new AccountType(null, "TEST");
        mvc.perform(post("/account-type")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(type)))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "luc.bernard", roles = "SUPER_ADMIN")
    public void createAccountType_asSuperAdmin_shouldReturn201() throws Exception {
        AccountType type = new AccountType(null, "TEST");
        mvc.perform(post("/account-type")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(type)))
                .andExpect(status().isCreated());
    }


    // ------------------------------------------------------------
    // PUT /account-type/{id}
    // ------------------------------------------------------------

    @Test
    @WithMockUser(username = "luc.bernard", roles = "SUPER_ADMIN")
    public void updateAccountType_asSuperAdmin_shouldReturn200() throws Exception {
        AccountType type = new AccountType(1, "UPDATED");

        mvc.perform(put("/account-type/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(type)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "luc.bernard", roles = "SUPER_ADMIN")
    public void updateAccountType_notExist_shouldReturn404() throws Exception {
        AccountType type = new AccountType(999, "UPDATED");

        mvc.perform(put("/account-type/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(type)))
                .andExpect(status().isNotFound());
    }


    // ------------------------------------------------------------
    // DELETE /account-type/{id}
    // ------------------------------------------------------------

    @Test
    @WithMockUser(username = "jean.dupont", roles = "USER")
    public void deleteAccountType_asUser_shouldReturn403() throws Exception {
        mvc.perform(delete("/account-type/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "claire.martin", roles = "ADMIN")
    public void deleteAccountType_asAdmin_shouldReturn403() throws Exception {
        mvc.perform(delete("/account-type/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "luc.bernard", roles = "SUPER_ADMIN")
    public void deleteAccountType_asSuperAdmin_shouldReturn204() throws Exception {
        mvc.perform(delete("/account-type/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser(username = "luc.bernard", roles = "SUPER_ADMIN")
    public void deleteAccountType_notExist_shouldReturn404() throws Exception {
        mvc.perform(delete("/account-type/999"))
                .andExpect(status().isNotFound());
    }
}

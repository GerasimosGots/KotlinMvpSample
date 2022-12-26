package com.app.kotlinmvpsample.useCase

import com.app.kotlinmvpsample.MockModelDataBuilder
import com.app.kotlinmvpsample.domain.useCase.UserModel
import com.app.kotlinmvpsample.domain.useCase.UserUseCase
import com.app.kotlinmvpsample.isValidMail
import com.app.kotlinmvpsample.isValidPhone
import io.reactivex.Single
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserUseCaseImplTest {

    @Mock
    private lateinit var useCase: UserUseCase

    // Object responsible return mock data
    private lateinit var mockDataBuilder : MockModelDataBuilder

    @Before
    fun setup() {
        // Start of each Test method -> Init Objects
        mockDataBuilder = MockModelDataBuilder()
    }

    @After
    fun tearDown() {
        // End of each Test -> Destroy objects
    }

    @Test
    fun `GIVEN user list, THEN the return model is UserModel`() {
        // Mock Data
        val mockData = mockDataBuilder.createMockUserModelList()
        val singleData = Single.just(mockData)

        // Mock return
        `when`(useCase.getUserList()).thenReturn(singleData)

        // GIVEN
        val actualModel = useCase.getUserList().blockingGet()

        // THEN result type is UserModel
        assertTrue(actualModel is MutableList<UserModel>)
    }

    @Test
    fun `GIVEN user list, THEN the return model is not empty`() {
        // Mock Data
        val mockData = mockDataBuilder.createMockUserModelList()
        val singleData = Single.just(mockData)

        // Mock return
        `when`(useCase.getUserList()).thenReturn(singleData)

        // GIVEN
        val actualModelList = useCase.getUserList().blockingGet()

        // THEN result type is List of UserModel
        assertTrue(actualModelList.isNotEmpty())
    }

    @Test
    fun `GIVEN selecting user, THEN id is equals with what we set`() {
        // Mock Data
        val mockData = mockDataBuilder.createMockUserModelList()[0]
        val singleData = Single.just(mockData)

        // Mock return
        `when`(useCase.getSelectedUser()).thenReturn(singleData)

        val expectedId = "0"

        // GIVEN
       useCase.selectedUser(expectedId)
       val actualId = useCase.getSelectedUser().blockingGet().id

        // THEN expected id is equals with actual id
        assertEquals(expectedId, actualId)
    }

    @Test
    fun `GIVEN selecting user, THEN id is a not empty id`() {
        // Mock Data
        val mockData = mockDataBuilder.createMockUserModelList()[0]
        val singleData = Single.just(mockData)

        // Mock return
        `when`(useCase.getSelectedUser()).thenReturn(singleData)
        val expectedId = "0"

        // GIVEN
        useCase.selectedUser(expectedId)
        val actualId = useCase.getSelectedUser().blockingGet().id

        // THEN expected id is not empty
        assertTrue(actualId.isNotEmpty())
    }

    @Test
    fun `GIVEN selecting user, THEN mail is valid mail`() {
        // Mock Data
        val mockData = mockDataBuilder.createMockUserModelList()[0]
        val singleData = Single.just(mockData)

        // Mock return
        `when`(useCase.getSelectedUser()).thenReturn(singleData)

        // GIVEN
        val actualMail = useCase.getSelectedUser().blockingGet().email

        // THEN expected mail is valid
        assertTrue(actualMail.isValidMail())
    }

    @Test
    fun `GIVEN selecting user, THEN mail is not valid mail`() {
        // Mock Data
        val mockData = mockDataBuilder.createMockUserModelList()[1]
        val singleData = Single.just(mockData)

        // Mock return
        `when`(useCase.getSelectedUser()).thenReturn(singleData)

        // GIVEN
        val actualMail = useCase.getSelectedUser().blockingGet().email

        // THEN expected mail is not valid
        assertFalse(actualMail.isValidMail())
    }

    @Test
    fun `GIVEN selecting user, THEN phone is valid phone`() {
        // Mock Data
        val mockData = mockDataBuilder.createMockUserModelList()[0]
        val singleData = Single.just(mockData)

        // Mock return
        `when`(useCase.getSelectedUser()).thenReturn(singleData)

        // GIVEN
        val actualMail = useCase.getSelectedUser().blockingGet().phone

        // THEN expected phone is valid
        assertTrue(actualMail.isValidPhone())
    }

    @Test
    fun `GIVEN selecting user, THEN phone is not valid phone`() {
        // Mock Data
        val mockData = mockDataBuilder.createMockUserModelList()[1]
        val singleData = Single.just(mockData)

        // Mock return
        `when`(useCase.getSelectedUser()).thenReturn(singleData)

        // GIVEN
        val actualMail = useCase.getSelectedUser().blockingGet().phone

        // THEN expected phone is not valid
        assertFalse(actualMail.isValidPhone())
    }
}
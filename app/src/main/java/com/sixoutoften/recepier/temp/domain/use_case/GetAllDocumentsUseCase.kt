package com.sixoutoften.recepier.temp.domain.use_case

import com.sixoutoften.recepier.temp.domain.model.Document
import com.sixoutoften.recepier.temp.domain.repository.DocumentRepository
import com.sixoutoften.recepier.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllDocumentsUseCase @Inject constructor(
    private val documentRepository: DocumentRepository
) {
    operator fun invoke(): Flow<Result<List<Document>>> = flow {
        emit(Result.Loading())
        emit(documentRepository.getAll())
    }
}
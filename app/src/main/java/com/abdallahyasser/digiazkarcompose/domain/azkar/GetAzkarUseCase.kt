package com.abdallahyasser.digi_azkar.domain.azkar

class GetAzkarUseCase(repo: AzkarRepositoryInter) {
    private val repository = repo

    suspend operator fun invoke(): List<Zekr> {
        return repository.getAzkar()
    }
}
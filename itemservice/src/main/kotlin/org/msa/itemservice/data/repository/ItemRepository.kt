package org.msa.itemservice.data.repository

import org.msa.itemservice.data.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, String>

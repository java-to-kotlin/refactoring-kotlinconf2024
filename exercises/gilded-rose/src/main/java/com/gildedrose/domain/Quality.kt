package com.gildedrose.domain

@JvmInline
value class Quality(
    val value: NonNegativeInt
) {
    val valueInt get() = value.value

    companion object {
        val ZERO: Quality = Quality(0)!!

        operator fun invoke(value: Int): Quality? {
            val wrapped = NonNegativeInt(value)
            return if (wrapped != null) Quality(wrapped) else null
        }
    }

    override fun toString() = value.toString()
}

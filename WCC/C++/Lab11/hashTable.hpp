#include "hashTable.h"

namespace DS
{

    // Returns true if and item was removed, false otherwise
    template <typename K, typename V>
    bool hashTable<K, V>::erase(const key_type &key)
    {
        size_t pos = hash(key, capacity);
        while (data[pos].flag != FREE && data[pos].key != key && pos != hash(key, capacity) - 1)
        {
            pos++;

            if (pos == capacity)
            {
                pos -= capacity;
            }
        }
        while (data[pos].flag == WAS_USED && data[pos].key == key && pos != hash(key, capacity) - 1)
        {
            pos++;

            if (pos == capacity)
            {
                pos -= capacity;
            }
        }
        if (data[pos].flag != INUSE || pos != hash(key, capacity) - 1)
        {
            return false;
        }
        data[pos].flag = WAS_USED;
        used--;
        return true;
    }

    // Returns a pointer to the data requested, nullptr if not found
    template <typename K, typename V>
    typename hashTable<K, V>::value_type *hashTable<K, V>::find(const key_type &key)
    {
        size_t pos = hash(key, capacity);
        while (data[pos].flag != FREE && data[pos].key != key && pos != hash(key, capacity) - 1)
        {
            pos++;
            if (pos == capacity)
            {
                pos -= capacity;
            }
        }
        if (data[pos].flag == FREE || pos != hash(key, capacity) - 1)
        {
            return nullptr;
        }
        return &data[pos].value;
    }

    // Returns 1 if found, 0 otherwise
    template <typename K, typename V>
    size_t hashTable<K, V>::count(const key_type &key) const
    {
        size_t pos = hash(key, capacity);
        while (data[pos].key != key && pos != hash(key, capacity) - 1)
        {
            pos++;

            if (pos == capacity)
            {
                pos -= capacity;
            }
        }
        if (data[pos].flag == FREE || pos != hash(key, capacity) - 1)
        {
            return 0;
        }
        size_t tot = 0;
        while (data[pos].key == key && pos != hash(key, capacity) - 1)
        {
            tot++;
            pos++;

            if (pos == capacity)
            {
                pos -= capacity;
            }
        }
        return tot;
    }

} // End DS Namespace
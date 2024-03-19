#include "items.h"
namespace DS
{
    bool items::same(items const *i) const
    {
        return i == this;
    }
    void items::reset()
    {
        set(everything);
    }
    void items::set(long const l)
    {
        current = l;
    }
    void items::set(std::string const &s)
    {
        long sum = 0;
        for (char c : s)
        {
            sum += c;
        }
        set(sum);
    }
    void items::set(items const &i)
    {
        set(i.get());
    }
    std::ostream &operator<<(std::ostream &out, items obj)
    {
        return out << obj.get();
    }
}
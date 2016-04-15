Realofit
========================

A simple library which give you ability to use realm object with retrofit convertor

```
            @Override
            public void onResponse(Call<LastQuestion> call, Response<LastQuestion> response) {

                // save it in realm easily
                realmObj.beginTransaction();
                realmObj.copyToRealmOrUpdate(response.body().getData().getChildren());
                realmObj.commitTransaction();

            }	
```

```
public class LastQuestion extends RealmObject {

    @PrimaryKey
    private String id = "LastQuestion";

    private String kind;

    @Realofit(LastQuestionData.class)
    private LastQuestionData data;

```

```
public class LastQuestionData extends RealmObject {

    @PrimaryKey
    private String id = "LastQuestionData";

    @Realofit(LastQuestionDataChildren.class)
    private RealmList<LastQuestionDataChildren> children;

    public RealmList<LastQuestionDataChildren> getChildren() {
        return children;
    }
```

```
public class LastQuestionDataChildrenData extends RealmObject {
    private String kind;
    private String thumbnail;
    private String title;
    private String permalink;

    @PrimaryKey
    private String id;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getThumbnail() {
        return thumbnail;
    }

```



License
-------

    Copyright 2015 Taskulu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
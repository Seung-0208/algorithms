#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Job {
    int idx, request, need;
};

struct CMP_BY_NEED {
    bool operator()(Job& a, Job& b) const {
        if(a.need != b.need) return a.need > b.need;
        else if(a.request != b.request) return a.request > b.request;
        else return a.idx > b.idx;
    }
};

struct CMP_BY_REQUEST { //요청시간 기준 오름차순
    bool operator()(Job& a, Job& b) const {
        if(a.request != b.request) return a.request > b.request;
        else if(a.need != b.need) return a.need > b.need;
        else return a.idx > b.idx;
    }  
};

int solution(vector<vector<int>> jobs) {
    priority_queue<Job, vector<Job>, CMP_BY_NEED> q;
    priority_queue<Job, vector<Job>, CMP_BY_REQUEST> rq;
    
    int n = jobs.size();
    
    for(int i=0; i<n; i++) {
        if(jobs[i][0] == 0) q.push({i, jobs[i][0], jobs[i][1]});
        if(jobs[i][0] > 0) rq.push({i, jobs[i][0], jobs[i][1]});
    }
    vector<int> times(n, 0);
    int sum = 0;
    
    if(q.empty()) {
        Job cur = rq.top();
        rq.pop();
        q.push(cur);
        sum = cur.request;
    }
    
    while(!q.empty()) {
        Job cur = q.top();
        q.pop();
        sum += cur.need;
        times[cur.idx] = sum-cur.request;
        
        //sum보다 요청 시간이 이전인 작업들을 큐에 반영
        while(!rq.empty() && rq.top().request <= sum) {
            Job cur = rq.top();
            rq.pop();
            q.push(cur);
        }
        
        if(q.empty() && !rq.empty()) {
            Job cur = rq.top();
            rq.pop();
            q.push(cur);
            sum = cur.request;
        }
    }
    
    int answer = 0;
    for(int t : times) {
        answer += t;
    }
    return answer/n;
}